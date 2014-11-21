(ns one.components.navigation
  "This namespace contains the implementation of the navigation bar
  component."
  (:require-macros [one.dom :refer [build-om]])
  (:require [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]
            [one.app-state :as app-state]
            [one.components.main :as main]))

;; Notice how React, via Om, makes this code awesome! We never have
;; to find a dom element and remove the active class. We just
;; describe when this node should have the class active and we now
;; have dynamic behaviour in the browser.
(defn nav-item
  [app-state {:keys [main text]}]
  (build-om
   [li (when (= (app-state/current-view app-state) main) #js {:className "active"})
    [a {:href (str "#" (name main))
        :onClick #(app-state/set-view! app-state main)}
     text]]))

(defn nav
  [app-state owner]
  (reify
    om/IRender
    (render [_]
      (build-om
       [nav "navbar navbar-default"
        [div "container-fluid"
         [div "navbar-header"
          [div "navbar-brand" "ClojureScript + Om"]]
         [div "collapse navbar-collapse"
          [ul "nav navbar-nav"
           [splice (map (fn [[main text]] (nav-item app-state {:main main :text text}))
                        main/main-views)]]]]]))))

(comment

  ;; without the build-om macro above, this would have been

  (defn nav
    [app-state owner]
    (reify
      om/IRender
      (render [_]
        (dom/nav #js {:className "navbar navbar-default"}
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

  )
