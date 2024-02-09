(ns sicp.chapter-2.part-3.ex-2-68
  (:require
    [sicp.chapter-2.part-3.book-2-3 :as b23]))

; Exercise 2.68
;
; The encode procedure takes as arguments a message and a tree and produces the list of bits that
; gives the encoded message.
;
; (define (encode message tree)
;   (if (null? message)
;       '()
;       (append
;        (encode-symbol (car message)
;                       tree)
;        (encode (cdr message) tree))))
;
; Encode-symbol is a procedure, which you must write, that returns the list of bits that encodes
; a given symbol according to a given tree. You should design encode-symbol so that it signals
; an error if the symbol is not in the tree at all. Test your procedure by encoding the result
; you obtained in Exercise 2.67 with the sample tree and seeing whether it is the same as the
; original sample message.

(defn encode-symbol
  [symbol tree]
  (cond (empty? tree) '()
        (b23/leaf? tree) '()
        (= symbol (b23/symbols tree)) '()
        :else (let [left-branch       (b23/left-branch-h tree)
                    right-branch      (b23/right-branch-h tree)
                    symbols-in-branch (b23/symbols tree)]
                (if (b23/element-of-set? symbol symbols-in-branch)
                  (if (b23/element-of-set? symbol (b23/symbols left-branch))
                    (cons 0 (encode-symbol symbol left-branch))
                    (cons 1 (encode-symbol symbol right-branch)))
                  (throw (Exception. (str "Symbol not found in tree " symbol)))))))

(defn encode
  [message tree]
  (if (empty? message)
    '()
    (concat
      (encode-symbol (first message) tree)
      (encode (rest message) tree))))
