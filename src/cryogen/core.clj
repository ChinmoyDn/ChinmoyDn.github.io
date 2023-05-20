(ns cryogen.core
  (:require [cryogen-core.compiler :refer [compile-assets-timed]]
            [cryogen-core.plugins :refer [load-plugins]]))

(defn compile-site []
  (compile-assets-timed
   {:update-article-fn
    (fn update-article [{:keys [slug] :as article} config]
      (if slug
        (assoc article :uri (str "/" slug "/"))
        article))}))

(defn -main []
  (load-plugins)
  (compile-site)
  (System/exit 0))
