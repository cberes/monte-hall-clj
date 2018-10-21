(ns monte-hall.strategy
  (:require [monte-hall.util :refer [random-door door-range]]))

(defprotocol Strategy
  (choose-initial-door [this])
  (choose-final-door [this initial-door goat-door]))

(deftype RetainDoorStrategy []
  Strategy
  (choose-initial-door [this] (random-door))
  (choose-final-door [this initial-door goat-door] initial-door))

(deftype ChangeDoorStrategy []
  Strategy
  (choose-initial-door [this] (random-door))
  (choose-final-door [this initial-door goat-door]
    (->> (door-range)
      (remove #(= initial-door %))
      (remove #(= goat-door %))
      (first))))

(deftype RandomDoorStrategy []
  Strategy
  (choose-initial-door [this] (random-door))
  (choose-final-door [this initial-door goat-door]
    (->> (door-range)
      (remove #(= goat-door %))
      (rand-nth))))

(def retain-door (RetainDoorStrategy.))

(def change-door (ChangeDoorStrategy.))

(def pick-door (RandomDoorStrategy.))
