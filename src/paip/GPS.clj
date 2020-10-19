; https://github.com/norvig/paip-lisp/blob/master/docs/chapter4.md

; General Problem Solver
; Challenges:
; Achieving goals in sequence may break earlier goals
; program needs ability to look ahead ands plan before axecuting irreversible actions
; infinite recursions


(ns paip.gps (:gen-class)
    (:require [clojure.set :as set]))

; An operation
(defrecord  Op
    [action preconds add-list del-list])

(defn make-op [action preconds add-list del-list]
    "Create Op ensuring correct collection types"
    (Op. action preconds (apply sorted-set add-list) (apply sorted-set del-list)))

; Tranformations: Vector of actions leading to the specified list of conditions
(defrecord Trans [actions state])

(defn chain [T1 T2]
    "Chain two transformation (T1 followed by T2)"
    (println "Chaining" T1 "with" T2)
    (Trans. (concat (:actions T1) (:actions T2)) (:state T2) ))

(declare solve achieve achieve-all operate appropriate)

(defn solve
    "Achieve all goals from state using ops. Returns actions or nil (if no solution)."
    [goals state ops]

    (when-some [trans (achieve-all goals (apply sorted-set state) ops)]
        (println "Solved:" (:actions trans) "yield" (:state trans))
        (:actions trans)))

(defn appropriate
    "Filters ops for which goal is in their add list."
    [ops goal]
    (filter #(contains? (:add-list %) goal) ops))

(defn achieve
    "A goal is achived if it already holds,
    or if there is an appropriate op for it that is applicable.
    Returns transformation (or nil otherwise)."
    [goal state ops]
    (println "Try achieve:" goal state ops )
    (if (.contains state goal)
        (do (println "New Trans for" state) (Trans. [] state))
        ; settles on first path identified
        (some #(operate % state ops) (appropriate ops goal))))


(defn achieve-all
    "Transformations to achieve all goals from state or nil"
    [goals state ops]
    ;carry over state across goals and chain resulting transformations
    (reduce
        ;exit early if one of goals not achievable
        #(if-let [a (achieve %2 (:state %1) ops)]
            a (reduced nil)) ;(do (println "Achieved:" a) a ) 
        (Trans. [] state)
        goals))


(defn operate
    "Apply operation and return transformation (or nil if not applicable)"
    [op state ops]
    ;recursively test if preconditions can be met
    (when-some [trans (achieve-all (:preconds op) state ops)]
    
        ; Construct and chain new transformation
        (chain trans (Trans. [(:action op)] (set/union
            (set/difference (:state trans) (:del-list op))
            (:add-list op))))))