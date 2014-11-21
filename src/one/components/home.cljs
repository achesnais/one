(ns one.components.home
  (:require [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]))

(defn home-view [_ _]
  (reify
    om/IRender
    (render [_]
      (dom/div nil "Home"))))
