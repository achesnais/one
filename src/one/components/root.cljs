(ns one.components.root
  (:require [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]
            [one.components.navigation :as nav]
            [one.components.main :as main]))

(defn root-view
  [app-state owner]
  (reify
    om/IRender
    (render [_]
      (dom/div nil
        (om/build nav/nav app-state)
        (main/main-view app-state)))))
