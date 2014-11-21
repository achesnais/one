(ns one.app-state
  "Functions for getting data out of and updating app state."
  (:require [om.core :as om]))

(defn current-view [app-state]
  (:view app-state))

(defn set-view! [app-state view]
  (om/update! app-state :view view))
