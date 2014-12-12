(ns one.components.navigation
  "This namespace contains the implementation of the navigation bar
  component."
  (:require-macros [kioo.om :refer [defsnippet]])
  (:require [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]
            [one.app-state :as app-state]
            [one.components.main :as main]
            [kioo.om :refer [content set-attr set-class do-> listen]]))

(defsnippet navbar-template "templates/navigation.html" [:#navbar]
  [nav-items]
  {[:.nav] (content nav-items)})

;; Notice how React makes this code awesome! We never have to find a
;; DOM element and remove the `active` class. We just describe when
;; this node should have the `active` class and React handles the
;; changes for us.
(defsnippet menu-item-template "templates/navigation.html" [:#navbar :.nav :> first-child]
  [key text active? click-handler]
  {[:li] (if active? (set-class "active") identity)
   [:a] (do-> (content text)
              (set-attr :href (str "#" (name key)))
              (listen :on-click click-handler))})

(defn nav-item
  [app-state {:keys [key text]}]
  (menu-item-template key
                      text
                      (= (app-state/current-view app-state) key)
                      #(app-state/set-view! app-state key)))

(defn nav
  [app-state owner]
  (reify
    om/IRender
    (render [_]
      (navbar-template (map (fn [[key text]] (nav-item app-state {:key key :text text}))
                            main/main-views)))))
