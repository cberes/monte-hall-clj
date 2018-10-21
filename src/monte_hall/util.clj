(ns monte-hall.util)

(def num-doors 3)

(defn random-door []
  (rand-int num-doors))

(defn door-range []
  (range num-doors))
