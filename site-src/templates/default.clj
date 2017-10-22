(let
    [config (static.config/config)
     path-to #(str (:url-base (static.config/config)) %)
     post? (= (:type metadata) :post)]
  (html5
   [:head
    [:meta {:name "description" :content (if post?
                                           (:description metadata)
                                           (:site-description config))}]
    [:meta {:name "keywords" :content (if post?
                                        (:tags metadata)
                                        (:site-keywords config))}]
    [:meta {:name "author" :content (:author-name config)}]
    [:meta {:charset "UTF-8"}]
    [:meta {:name "viewport" :content "width-=device-width initial-scale=1"}]
    [:title (:site-title config)]
    [:link {:rel "stylesheet"
            :type "text/css"
            :href (path-to "/default.css")}]
    (if post?
      [:link {:rel "canonical"
              :href (path-to (str (:site.url config) (:url metadata)))}])]
   [:body
    [:div
     {:id "wrap"}
     [:div
      {:id "header"}
      [:h1
       [:a
        {:href (path-to "/")}
        (:site-title config)]]
      [:ul
       {:id "navigation"}
       [:li
        [:a {:href (path-to "/" ) :class "page"} "Home"]]
       [:li
        [:a {:href (path-to "/about.html") :class "page" :rel "author"} "About"]]]]
     [:div
      {:id "content"}
      [:div
       {:id "post"}
       [:h1 (:title metadata)]
       content]]

     ]]))
