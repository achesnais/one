(ns one.app
  (:require [om.core :as om :include-macros true]
            [one.components.root :as root]))

(defn app-root [app-state dom-element shared]
  (om/root root/root-view
           app-state
           {:target dom-element
            :shared shared}))

(defn new-app [dom-id app-state shared]
  (app-root app-state
            (.getElementById js/document dom-id)
            shared))
