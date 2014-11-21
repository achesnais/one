(ns one.main
  "Functions for starting and stopping the application."
  (:require [one.app :as app]
            [one.components.main :as main-component]
            [figwheel.client :as fw :include-macros true]))

(enable-console-print!)

(def initial-state {:view main-component/initial-view})

(fw/watch-and-reload
 :jsload-callback #(print "reloaded"))

(defn ^:export start [dom-id]
  (let [app-state (atom initial-state)]
    (app/new-app dom-id app-state {})))
