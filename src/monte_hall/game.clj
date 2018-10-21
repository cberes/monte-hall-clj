(ns monte-hall.game
  (:require [monte-hall.strategy :as strat]
            [monte-hall.util :refer [random-door door-range]]))

(defn pick-goat [{winner :winner, initial-choice :initial-choice, :as state}]
  (assoc state :goat (->> (door-range)
                       (remove #(= winner %))
                       (remove #(= initial-choice %))
                       (rand-nth))))

(defn mk-initial-choice [state strategy]
  (assoc state :initial-choice (strat/choose-initial-door strategy)))

(defn mk-final-choice [{goat :goat, initial-choice :initial-choice, :as state} strategy]
  (assoc state :final-choice (strat/choose-final-door strategy initial-choice goat)))

(defn play
  ([strategy]
    (play strategy (random-door)))
  ([strategy winner]
    (-> {}
      (assoc :winner winner)
      (mk-initial-choice strategy)
      (pick-goat)
      (mk-final-choice strategy))))

(defn is-winner? [{winner :winner, final-choice :final-choice}]
  (= winner final-choice))
