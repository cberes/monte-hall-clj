(ns monte-hall.simulation
  (:require [monte-hall.game :refer [play is-winner?]]))

(defn sim [strategy n]
  {:samples n :success (->> (repeatedly n #(play strategy))
                         (filter is-winner?)
                         (count))})
