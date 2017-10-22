{:title ""}

[:ul {:class "posts"}
 (map
  #(let [f %
         url (static.core/post-url f)
         [metadata _] (static.io/read-doc f)]
     [:li
      [:a {:href (str (:url-base (static.config/config)) url)} (:title metadata)]])
  (take 25 (static.io/list-files :posts)))]
