(ns one.main
  "Functions for starting and stopping the application."
  (:require [one.app :as app]))

(def initial-state {:view :home})

(defn ^:export start [dom-id]
  (let [app-state (atom initial-state)]
    (app/new-app dom-id app-state {})))
