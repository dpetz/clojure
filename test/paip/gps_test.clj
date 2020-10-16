(ns paip.gps-test
    (:require [clojure.test :refer :all]
        [paip.gps :refer :all]))

(defn apply-op-test []
    "Unit test paip.gps/apply-op"
   (let [msg 'Hi] (print msg)))

(paip.gps-test/apply-op-test)

;;(let [op (paip.gps.Op.
;;    :A-to-B
;;    (set :A)
;;    (set :B)
;;    (set :A))]
 ;;   (print op)))
 ;;       (apply-op
 ;;           op
 ;;           (set :A)
 ;;           (set op))))