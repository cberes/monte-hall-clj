(ns monte-hall.core
  (:require [monte-hall.simulation :refer [sim]]
            [monte-hall.strategy :as strat])
  (:gen-class))

(def n 10000)

(defn describe [{samples :samples, won :success}]
  (str samples " trials: won " won ", lost " (- samples won) " (" (float (/ won samples)) ")"))

(defn -main
  "Run the simulation once per strategy"
  [& args]
  (println "Keep same door")
  (println (describe (sim strat/retain-door n)))
  (println "Change door")
  (println (describe (sim strat/change-door n)))
  (println "Random door")
  (println (describe (sim strat/pick-door n))))
