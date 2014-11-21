(ns one.app-state
  "Instead of spreading knowledge of the structure of app state all
  over the application, confine that knowledge to this one
  namespace. Provides semantic functions for accessing and updating
  app state."
  (:require [om.core :as om]))

(defn current-view
  "Given the app-state cursor or value, return the current view."
  [app-state]
  (:view app-state))

(defn set-view!
  "Given the app-state cursor and a view, make the provided view the
  current view."
  [app-state view]
  (om/update! app-state :view view))
