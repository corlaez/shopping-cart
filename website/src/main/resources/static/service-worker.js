//var values = "minimal-ui fullscreen standalone";
var LAMATOR_CACHE = 'lamator';

self.addEventListener('install', function(e) {
    e.waitUntil(
        caches.open(LAMATOR_CACHE).then(function(cache) {
            return cache.addAll([
                '/',
                '/store',
                '/store/Todo',
                '/store/Abrigos',
                '/store/Gorros',
                '/store/Otros',

                '/css/core.css',
                '/css/store2.css',

                '/js/store2.js',

                '/manifest.json',
                '/?utm_source=homescreen'
            ]);
        })
    );
});
self.addEventListener('fetch', function(event) {
    // console.log('fetch sw' + event.request.url);

    //cache first (problems because it is not updating properly even when connected)
    //fix short lived cache? not optimal
    // event.respondWith(
    //     caches.match(event.request).then(function(response) {
    //         return response || fetch(event.request);
    //     })
    // );

    //network first (problems because it is not updating on fetch)
    //fix update on fetch. optimal. DONE AND TESTED =D
    event.respondWith(
        fetch(event.request)
            .catch(function() {
                console.log('No network. Use cache!');
                return caches.match(event.request)
            .then(function(response) {
                // If it's error, return
                if(!response || response.status !== 200 || response.type !== 'basic') {
                    return response;
                }
                // Clone the response stream 1 to cache other to browser
                var responseToCache = response.clone();
                caches.open(LAMATOR_CACHE)
                    .then(function(cache) {
                        cache.put(event.request, responseToCache);
                    });
                console.log('cache updated, response delivered');
                return response;
            });
        })
    );
});