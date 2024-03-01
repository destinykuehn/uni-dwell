(g=>{var h,a,k,p="The Google Maps JavaScript API",c="google",l="importLibrary",q="__ib__",m=document,b=window;b=b[c]||(b[c]={});var d=b.maps||(b.maps={}),r=new Set,e=new URLSearchParams,u=()=>h||(h=new Promise(async(f,n)=>{await (a=m.createElement("script"));e.set("libraries",[...r]+"");for(k in g)e.set(k.replace(/[A-Z]/g,t=>"_"+t[0].toLowerCase()),g[k]);e.set("callback",c+".maps."+q);a.src=`https://maps.${c}apis.com/maps/api/js?`+e;d[q]=f;a.onerror=()=>h=n(Error(p+" could not load."));a.nonce=m.querySelector("script[nonce]")?.nonce||"";m.head.append(a)}));d[l]?console.warn(p+" only loads once. Ignoring:",g):d[l]=(f,...n)=>r.add(f)&&u().then(()=>d[l](f,...n))})({
    key: "AIzaSyBV7tfcU55KcXBpnyNLv7e15vlWM6K2WQE",
    v: "weekly",
});
let map;
async function initMap(theme) {
    // NMT coordinates
    const position = {lat: 34.068978220312005, lng: -106.90560937652961};
    const { Map } = await google.maps.importLibrary("maps");
    const { AdvancedMarkerElement } = await google.maps.importLibrary("marker");
    const bounds = new google.maps.LatLngBounds(
        new google.maps.LatLng(34.02276502506655, -106.94102989126084), // Southwest corner
        new google.maps.LatLng(34.09955905027666, -106.86601387666968)  // Northeast corner
    );
    let mapId = (theme === "light") ? "b615488547e0b44a" : "ffc8ae760a796c6b"
    map = new Map(document.getElementById("map"), {
        zoom: 13,
        center: position,
        mapId: mapId,
        // fullscreenControl: false,
        // streetViewControl: false,
        // zoomControlOptions: {
        //     style: google.maps.ZoomControlStyle.SMALL,
        //     position: google.maps.ControlPosition.LEFT_BOTTOM
        // },
        restriction: {
            latLngBounds: bounds,
            strictBounds: false,
        },
        disableDefaultUI: true,
        zoomControl: true,
    });

    // const marker = new AdvancedMarkerElement({
    //     map: map,
    //     position: position,
    //     title: "NMT",
    // });
}