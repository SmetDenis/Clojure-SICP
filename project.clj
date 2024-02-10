(defproject smetdenis/clojure-sicp "0.1"
  :description "Solving exercises from SICP with Clojure"
  :url "https://github.com/SmetDenis/Clojure-SICP"
  :license {:name "MIT"
            :url  "http://opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.11.1"]]
  :source-paths ["src"]
  :test-paths ["test"]
  :main ^:skip-aot sicp
  :target-path "build/%s"
  :plugins [[jonase/eastwood "1.4.2"]]
  :profiles {:dev      {:dependencies [[io.github.noahtheduke/splint "1.12"]
                                       [jonase/eastwood "1.4.2"]
                                       [org.clojure/clojure "1.11.1"]]}
             :test     {:main-opts ["-m" "cognitect.test-runner"]}
             :eastwood {:main-opts ["-m" "eastwood.lint" {}]}
             :uberjar  {:aot :all}
             :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}
  :aliases {"splint" ["run" "-m" "noahtheduke.splint"]})
