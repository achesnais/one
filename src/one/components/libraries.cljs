(ns one.components.libraries
  (:require [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]))

(defn libraries-view [_ _]
  (reify
    om/IRender
    (render [_]
      (dom/div nil "Libraries"))))
