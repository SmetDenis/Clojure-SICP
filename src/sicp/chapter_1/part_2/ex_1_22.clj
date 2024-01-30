(ns sicp.chapter-1.part-2.ex-1-22)

; Exercise 1.22
; Most Lisp implementations include a primitive called runtime that returns an integer that specifies
; the amount of time the system has been running (measured, for example, in microseconds).
; The following timed-prime-test procedure, when called with an integer n, prints n and checks to see if n is prime.
; If n is prime, the procedure prints three asterisks followed by the amount of time used in performing the test.

;(define (timed-prime-test n)
;        (newline)
;        (display n)
;        (start-prime-test n (runtime)))
;
;(define (report-prime elapsed-time)
;        (display " *** ")
;        (display elapsed-time))
;
;(define (start-prime-test n start-time)
;        (if (prime? n)
;          (report-prime (- (runtime) start-time))))

; Using this procedure, write a procedure search-for-primes that checks the primality of
; consecutive odd integers in a specified range.
; Use your procedure to find the three smallest primes larger than: 1000, 10,000, 100,000 and 1,000,000.
;
; Note the time needed to test each prime. Since the testing algorithm has order of growth of O(n),
; you should expect that testing for primes around 10,000 should take about sqrt(10) times as long as
; testing for primes around 1000. Do your timing data bear this out? How well do the data for 100,000
; and 1,000,000 support the n prediction?
; Is your result compatible with the notion that programs on your machine run in time proportional
; to the number of steps required for the computation?

(defn find-primes
  [from to print-log]
  (cond (>= from to) (do
                       (when print-log (println "finish"))
                       from)
        (even? from) (find-primes (+ from 1) to print-log)  ; Just skip to the next odd
        :else (do
                (when print-log (println from))
                (find-primes (+ from 2) to print-log))))    ; Takes only odds
