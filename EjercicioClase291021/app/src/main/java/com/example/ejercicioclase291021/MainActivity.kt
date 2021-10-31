package com.example.ejercicioclase291021

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    private lateinit var etNombre:EditText
    private lateinit var etApellido:EditText
    private lateinit var rbMasc:RadioButton
    private lateinit var rbFem:RadioButton
    private lateinit var spinDepartamento:Spinner
    private lateinit var spinMunicipio:Spinner
    private lateinit var etTelefono:EditText
    private lateinit var tvRegistro:TextView
    private var Registros = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etNombre = findViewById(R.id.etNombre)
        etApellido = findViewById(R.id.etApellido)
        rbMasc = findViewById(R.id.rbMasc)
        rbFem = findViewById(R.id.rbFem)
        spinDepartamento = findViewById(R.id.spinDepartamento)
        spinMunicipio = findViewById(R.id.spinMunicipio)
        etTelefono =findViewById (R.id.etTelefono)
        tvRegistro = findViewById(R.id.tvRegistro)

        //Lenando el spinner de Departamentos
        val opciones = arrayOf(
            "Seleccione una opcion",
            "San Salvador",
            "Chalatenango",
            "Sonsonate",
            "La Paz",
            "La Libertad",
            "San Miguel",
            "Usulután",
            "Cabañas",
            "Santa Ana",
            "San Vicente",
            "La Unión",
            "Morazán",
            "Cuscatlán",
            "Ahuachapán"
        )
        val adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item, opciones)
        spinDepartamento.adapter = adaptador

        //Funcion para recoger un listado de municipios de acuerdo a un departamento
        fun getMunicipios(depto:String):ArrayList<String>{
            val muni= arrayListOf<String>()
            when(depto){
                "Chalatenango"->muni.addAll(listOf("Seleccione una opcion","Agua Caliente","Arcatao","Azacualpa","Chalatenango","Citalá","Comalapa","Concepción Quezaltepeque",
                    "Dulce Nombre de María","El Carrizal","El Paraíso","La Laguna","La Palma","La Reina","Las Vueltas","Nombre de Jesús","Nueva Concepción",
                    "Nueva Trinidad","Ojos de Agua","Potonico","San Antonio de la Cruz","San Antonio Los Ranchos","San Fernando","San Francisco Lempa",
                    "San Francisco Morazán","San Ignacio","San Isidro Labrador","San José Cancasque (Cancasque)","San José Las Flores","San Luis del Carmen",
                    "San Miguel de Mercedes","San Rafael","Santa Rita","Tejutla"))
                "San Salvador"->muni.addAll(listOf("Seleccione una opcion","Aguilares","Apopa","Ayutuxtepeque","Ciuddad Delgado","Cuscatancingo","El Paisnal","Guazapa","Ilopango",
                    "Mejicanos","Nejapa","Panchimalco","Rosario de Mora","San Marcos","San Martín","San Salvador","Santiago Texacuangos","Santo Tomás",
                    "Soyapango","Tonacatepeque"))
                "Sonsonate"->muni.addAll(listOf("Seleccione una opcion","Acajutla","Armenia","Caluco","Cuisnahuat","Izalco","Juayúa","Nahuizalco","Nahulingo","Salcoatitán",
                    "San Antonio del Monte","San Julián","Santa Catarina Masahuat","Santa Isabel Ishuatán","Santo Domingo de Guzmán","Sonsonate",
                    "Sonzacate"))
                "La Paz"->muni.addAll(listOf("Seleccione una opcion","Cuyultitán","El Rosario (Rosario de La Paz)","Jerusalén","Mercedes La Ceiba","Olocuilta","Paraíso de Osorio",
                    "San Antonio Masahuat","San Emigdio","San Francisco Chinameca","San Juan Nonualco","San Juan Talpa","San Juan Tepezontes",
                    "San Luis La Herradura","San Luis Talpa","San Miguel Tepezontes","San Pedro Masahuat","San Pedro Nonualco","San Rafael Obrajuelo",
                    "Santa María Ostuma","Santiago Nonualco","Tapalhuaca","Zacatecoluca"))
                "La Libertad"->muni.addAll(listOf("Seleccione una opcion","Antiguo Cuscatlán","Chiltiupán","Ciudad Arce","Colón","Comasagua","Huizúcar","Jayaque","Jicalapa",
                    "La Libertad","Santa Tecla (Nueva San Salvador)","Nuevo Cuscatlán","San Juan Opico","Quezaltepeque","Sacacoyo",
                    "San José Villanueva","San Matías","San Pablo Tacachico","Talnique","Tamanique","Teotepeque","Tepecoyo","Zaragoza"))
                "San Miguel"->muni.addAll(listOf("Seleccione una opcion","Carolina","Chapeltique","Chinameca","Chirilagua","Ciudad Barrios","Comacarán","El Tránsito","Lolotique",
                    "Moncagua","Nueva Guadalupe","Nuevo Edén de San Juan","Quelepa","San Antonio del Mosco","San Gerardo","San Jorge",
                    "San Luis de la Reina","San Miguel","San Rafael Oriente","Sesori","Uluazapa"))
                "Usulután"->muni.addAll(listOf("Seleccione una opcion","Alegría","Berlín","California","Concepción Batres","El Triunfo","Ereguayquín","Estanzuelas","Jiquilisco",
                    "Jucuapa","Jucuarán","Mercedes Umaña","Nueva Granada","Ozatlán","Puerto El Triunfo","San Agustín","San Buenaventura",
                    "San Dionisio","San Francisco Javier","Santa Elena","Santa María","Santiago de María","Tecapán","Usulután"))
                "Cabañas"->muni.addAll(listOf("Seleccione una opcion","Cinquera","Dolores (Villa Doleres)","Guacotecti","Ilobasco","Jutiapa","San Isidro",
                    "Sensuntepeque","Tejutepeque","Victoria"))
                "Santa Ana"->muni.addAll(listOf("Seleccione una opcion","Candelaria de la Frontera","Chalchuapa","Coatepeque","El Congo","El Porvenir","Masahuat","Metapán",
                    "San Antonio Pajonal","San Sebastián Salitrillo","Santa Ana","Santa Rosa Guachipilín","Santiago de la Frontera","Texistepeque"))
                "San Vicente"->muni.addAll(listOf("Seleccione una opcion","Apastepeque","Guadalupe","San Cayetano Istepeque","San Esteban Catarina","San Ildefonso","San Lorenzo",
                    "San Sebastián","San Vicente","Santa Clara","Santo Domingo","Tecoluca","Tepetitán","Verapaz"))
                "La Unión"->muni.addAll(listOf("Seleccione una opcion","Anamorós","Bolívar","Concepción de Oriente","Conchagua","El Carmen","El Sauce","Intipucá","La Unión","Lilisque",
                    "Meanguera del Golfo","Nueva Esparta","Pasaquina","Polorós","San Alejo","San José","Santa Rosa de Lima","Yayantique","Yucuaiquín"))
                "Morazán"->muni.addAll(listOf("Seleccione una opcion","Arambala","Cacaopera","Chilanga","Corinto","Delicias de Concepción","El Divisadero","El Rosario","Gualococti",
                    "Guatajiagua","Joateca","Jocoaitique","Jocoro","Lolotiquillo","Meanguera","Osicala","Perquín","San Carlos","San Fernando",
                    "San Francisco Gotera","San Isidro","San Simón","Sensembra","Sociedad","Torola","Yamabal","Yoloaiquín"))
                "Cuscatlán"->muni.addAll(listOf("Seleccione una opcion","Candelaria","Cojutepeque","El Carmen","El Rosario","Monte San Juan","Oratorio de Concepción","San Bartolomé Perulapía",
                    "San Cristóbal","San José Guayabal","San Pedro Perulapán","San Rafael Cedros","San Ramón","Santa Cruz Analquito","Santa Cruz Michapa",
                    "Suchitoto","Tenancingo"))
                "Ahuachapán"->muni.addAll(listOf("Seleccione una opcion","Ahuachapán","Apaneca","Atiquizaya","Concepción de Ataco","El Refugio","Guaymango","Jujutla",
                    "San Francisco Menéndez","San Lorenzo","San Pedro Puxtla","Tacuba","Turín"))
            }
            return muni
        }

        //Esta parte simula el evento ItemChange de una lista
        spinDepartamento?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {}

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                //Codigo para cargar el otro spinner
                var depart:String=spinDepartamento.selectedItem.toString()
                val adaptadorMuni = ArrayAdapter(applicationContext, android.R.layout.simple_spinner_item, getMunicipios(depart))
                spinMunicipio.adapter=adaptadorMuni
            }
        }

    }

    fun Registrar(Vista:View){
        Registros.clear()
        Registros.add(etNombre.text.toString())
        Registros.add(etApellido.text.toString())
        Registros.add(spinDepartamento.selectedItem.toString())
        Registros.add(spinMunicipio.selectedItem.toString())
        if(rbFem.isChecked){
            Registros.add("Femenino")
        }else if(rbMasc.isChecked){
            Registros.add("Masculino")
        }
        Registros.add(etTelefono.text.toString())
    }
    fun MostrarRegistro(Vista: View){
        tvRegistro.setText("Nombre: "+Registros[0] + "\n" +
                "Apellido: " + Registros[1] + "\n" +
                "Departamento: "+Registros[2] + "\n" +
                "Municipio: "+Registros[3] + "\n" +
                "Sexo: "+Registros[4] + "\n" +
                "Telefono: "+Registros[5] + "\n")
    }
}