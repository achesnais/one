(ns one.components.navigation
  (:require [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]
            [one.app-state :as app-state]
            [one.components.main :as main]))

(defn nav-item
  [app-state {:keys [main text]}]
  (dom/li (when (= (app-state/current-view app-state) main) #js {:className "active"})
    (dom/a
     #js {:href (str "#" (name main))
          :onClick #(app-state/set-view! app-state main)}
     text)))

(defn nav
  [app-state owner]
  (reify
    om/IRender
    (render [_]
      (dom/nav #js {:className "navbar navbar-default" :role "navigation"}
               (dom/div #js {:className "container-fluid"}
                        (dom/div #js {:className "navbar-header"}
                                 (dom/div #js {:className "navbar-brand"}
                                          "ClojureScript + Om"))
                        (dom/div #js {:className "collapse navbar-collapse"}
                                 (apply dom/ul #js {:className "nav navbar-nav"}
                                        (map
                                         (fn [[main text]]
                                           (nav-item app-state {:main main :text text}))
                                         main/main-views))))))))
