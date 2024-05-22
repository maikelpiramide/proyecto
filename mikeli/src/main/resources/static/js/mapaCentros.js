$(document).ready(()=>{

    //mapa base
    var map = new L.Map('mapa',{
        fullscreenControl:true,
        fullscreenControl: {
            pseudoFullscreen: false
        }
    })
    map.setView([42.13842, -0.40909], 13);

    L.tileLayer('https://tile.openstreetmap.org/{z}/{x}/{y}.png', {
        attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors',
    }).addTo(map);

    var overlayMaps = {};
    var layersControl = L.control.layers(null,overlayMaps).addTo(map)

    var centrosMedicosCapa = L.layerGroup();
    var centrosMedicosGuardiaCapa = L.layerGroup();

    //petición para obtener centros
    $.ajax({
        url:"/api/getCentrosMedicos",
        method:"GET",
        success:(response)=>{
            //console.log(response)
            response.forEach((centro)=>{
                if(centro.urgencias){
                    var marca = L.marker([centro.latitud,centro.longitud])
                        .bindPopup(`<b>${centro.nombre}</b> <br>Apertura: ${centro.apertura} <br>Cierre: ${centro.cierre} <br>Urgencias: Sí`);

                    centrosMedicosGuardiaCapa.addLayer(marca)
                }else{
                    var marca = L.marker([centro.latitud,centro.longitud])
                        .bindPopup(`<b>${centro.nombre}</b> <br>Apertura: ${centro.apertura} <br>Cierre: ${centro.cierre} <br>Urgencias: No`);
                    centrosMedicosCapa.addLayer(marca)
                }
            })

            centrosMedicosGuardiaCapa.addTo(map)
            centrosMedicosCapa.addTo(map)

            layersControl.addOverlay(centrosMedicosGuardiaCapa,"Centros Médicos Urgencias")
            layersControl.addOverlay(centrosMedicosCapa,"Centros Médicos")


        },
        error:(err)=>{
            console.log("rerror obteninedo los centros")
        }
    })
    //peticionn a farmacias
    var farmaciasGuardiaCapa = L.layerGroup()
    var farmaciasCapa = L.layerGroup()
    $.ajax({
        url:"/api/getFarmacias",
        method:"GET",
        success:(response)=>{
            //console.log("farmacias")
            //console.log(response)
            response.forEach((farmacia)=>{
                if(farmacia.guardia){
                    var marca = L.marker([farmacia.latitud,farmacia.longitud])
                        .bindPopup(`<b>${farmacia.nombre}</b> <br>Apertura: ${farmacia.apertura} <br>Cierre: ${farmacia.cierre} <br>Guardia: Sí`);

                    farmaciasGuardiaCapa.addLayer(marca)
                }else{
                    var marca = L.marker([farmacia.latitud,farmacia.longitud])
                        .bindPopup(`<b>${farmacia.nombre}</b> <br>Apertura: ${farmacia.apertura} <br>Cierre: ${farmacia.cierre} <br>Guardia: No`);
                    farmaciasCapa.addLayer(marca)
                }
            })
            farmaciasGuardiaCapa.addTo(map)
            farmaciasCapa.addTo(map)

            layersControl.addOverlay(farmaciasGuardiaCapa,"Farmacias Guardia")
            layersControl.addOverlay(farmaciasCapa,"Farmaciass")
        },
        error:(err)=>{
            console.log("rerror obteninedo las farmacias")
        }
    })





    // L.marker([51.5, -0.09]).addTo(map)
    //     .bindPopup('A pretty CSS popup.<br> Easily customizable.')
    //     .openPopup();
})