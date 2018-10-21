(defproject monte-hall-clj "1.0.0-SNAPSHOT"
  :description "Simulates the Monte Hall problem"
  :url "https://github.com/cberes/monte-hall-clj"
  :license {:name "GNU General Public License"
            :url "https://www.gnu.org/licenses/gpl.html"}
  :dependencies [[org.clojure/clojure "1.9.0"]]
  :main ^:skip-aot monte-hall.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
