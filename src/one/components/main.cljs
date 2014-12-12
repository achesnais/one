(ns one.components.main
  (:require-macros [kioo.om :refer [defsnippet]])
  (:require [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]
            [one.app-state :refer [current-view]]
            [one.components.home :as home]
            [one.components.libraries :as libraries]
            [kioo.om :refer [content]]))

(defsnippet main-view-template "templates/navigation.html" [:#mainview]
  [main-content]
  {[:div] (content main-content)})

(def initial-view :home)

(def main-views
  {:home       "Home"
   :libraries  "Libraries"})

(defn unknown-view [app-state _]
  (reify
    om/IRender
    (render [_]
      (dom/div nil (str "Unknown view: " (current-view app-state))))))

(defn main-view [app-state]
  (let [component (case (current-view app-state)
                    :home home/home-view
                    :libraries libraries/libraries-view
                    unknown-view)]
    (main-view-template (om/build component app-state))))
