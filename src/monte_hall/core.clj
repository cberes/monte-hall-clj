(ns monte-hall.core
  (:require [monte-hall.strategy :as strat])
  (:gen-class))

(defn -main
  "Run the simulation once per strategy"
  [& args]
  (println (strat/choose-initial-door strat/retain-door))
  (println (strat/choose-final-door strat/retain-door 0 2))
  (println (strat/choose-initial-door strat/change-door))
  (println (strat/choose-final-door strat/change-door 0 2)))
