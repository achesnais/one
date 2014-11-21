(ns one.app
  "This namespace provides functions to create the user interface for
  this application."
  (:require [om.core :as om :include-macros true]
            [one.components.root :as root]))

;; The shared components which are provided here will allow user
;; interface components to update domain state, communicate events to
;; each other, and send and receive data from services.
(defn create-ui
  "Given a dom-id, app-state atom and a map of shared components,
  create and display the user interface."
  [dom-id app-state shared]
  (om/root root/root-view
           app-state
           {:target (.getElementById js/document dom-id)
            :shared shared}))
