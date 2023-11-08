<h1 style="text-align: center;">Rapport de Projet Hospital Project</h1>
<h2>Introduction</h2>
<p style="text-align: justify; text-justify: inter-word;">Ce rapport se concentre sur le projet "Hospital Project", 
une application de gestion hospitalière élaborée pour démontrer divers concepts de développement logiciel, de gestion de données et de création d'API REST 
en utilisant le framework Spring Boot. Il explore en détail les différentes composantes du projet, notamment sa conception, sa structure et l'utilisation d'annotations essentielles pour configurer et gérer les entités, les repositories et les contrôleurs REST. De plus, il offre une vue approfondie sur la configuration de la base de données H2 en mémoire, ainsi que sur l'établissement des relations entre les entités du projet.

L'objectif principal de ce rapport est de présenter une analyse complète du projet "Hospital Project",
en mettant en avant les concepts et les techniques clés employés tout au long de son développement.
</p>
<h2>Conception du Projet</h2>
<img src="captures/conception.PNG" alt="Conception">
<h2>Structure du Projet</h2>
<p style="text-align: justify; text-justify: inter-word;">Le projet "Hospital Project" est organisé en plusieurs packages et comprend les éléments suivants :</p>
<ol>
  <li><strong>ma.meriem.hospitalProject.entities :</strong>
    Ce package contient les classes qui représentent les entités du projet.
    <ul>
      <li><strong>Patient :</strong> Cette classe représente les patients de l'hôpital. Elle comprend des informations telles que le nom du patient, sa date de naissance, son état de maladie et une relation vers les rendez-vous associés.</li>
      <li><strong>Medecin :</strong> Cette classe représente les médecins travaillant à l'hôpital. Elle inclut des informations telles que le nom du médecin, son adresse e-mail, sa spécialité (cardiologue ou dentiste) et une relation vers les rendez-vous associés.</li>
      <li><strong>RendezVous :</strong> Cette classe représente les rendez-vous entre les patients et les médecins. Elle comprend des informations sur la date du rendez-vous, son statut (en attente, annulé ou effectué), ainsi que des relations vers le patient, le médecin et la consultation associée.</li>
      <li><strong>Consultation :</strong> La classe Consultation est liée à un rendez-vous et contient des informations sur la date de la consultation et un rapport médical.</li>
    </ul>
  </li>

  <li><strong>hospitalProject.repositories :</strong>
    Ce package contient les interfaces de gestion des données pour chaque entité, utilisant Spring Data JPA pour effectuer les opérations de base.
  </li>

  <li><strong>hospitalProject.service :</strong> Ce package contient l'interface IHospitalService et son implémentation HospitalServiceImpl. L'interface définit des méthodes pour sauvegarder des patients, des médecins, des rendez-vous, et des consultations. L'implémentation utilise les repositories pour gérer les entités et crée des relations entre elles.</li>

  <li><strong>hospitalProject.web :</strong> Ce package contient le contrôleur PatientRestController, qui expose une API REST pour récupérer la liste des patients.</li>
</ol>

<h2>Utilisation des Annotations</h2>
<p style="text-align: justify; text-justify: inter-word;" >Les annotations sont largement utilisées dans le projet pour configurer les entités, les repositories, et les contrôleurs REST. Voici un résumé des annotations clés et de leur utilité :</p>
<ol>
  <li><strong>Annotations liées aux entités :</strong>
    <ul>
      <li><strong>@Entity :</strong> Marque les classes comme des entités persistantes, mappées sur des tables de base de données.</li>
      <li><strong>@Id :</strong> Définit un champ comme la clé primaire de l'entité.</li>
      <li><strong>@GeneratedValue(strategy = GenerationType.IDENTITY) :</strong> Définit la stratégie de génération des valeurs de la clé primaire, indiquant que la base de données génère automatiquement les valeurs.</li>
      <li><strong>@JsonProperty(access = JsonProperty.Access.WRITE_ONLY) :</strong> Contrôle la sérialisation JSON des entités en excluant certains champs de la réponse JSON.</li>
      <li><strong>@Enumerated(EnumType.STRING) :</strong> Utilisée pour stocker 
les valeurs d'une énumération sous forme de chaînes de caractères dans la base
de données, ce qui facilite la lisibilité des données.</li>
<li><strong>@AllArgsConstructor:</strong> Cette annotation est généralement associée au framework Lombok. 
 Elle génère automatiquement un constructeur qui prend tous les champs 
 de la classe en tant que paramètres. Cela simplifie la création d'instances de
 la classe en évitant d'écrire manuellement 
 un constructeur avec de nombreux paramètres.</li>
<li><strong>@NoArgsConstructor:</strong> Cette annotation, également associée à Lombok, génère
un constructeur sans aucun paramètre. Cela permet de créer des instances de la classe sans avoir 
à spécifier de valeurs pour les champs. Ces constructeurs sont couramment utilisés dans les 
classes d'entités pour permettre la création d'instances vides.
</li>
<li><strong>@Data:</strong>  Cette annotation de Lombok génère automatiquement des méthodes
getter, setter, equals(), hashCode(), et toString() pour tous les champs de la classe. Cela réduit
considérablement le code boilerplate en évitant d'écrire manuellement ces méthodes. 
L'annotation @Data simplifie la gestion des entités en automatisant la génération de ces
méthodes essentielles.
</li>
</ul>
  </li>

  <li><strong>Annotations liées aux repositories :</strong>
    <ul>
      <li><strong>@Repository :</strong> Indique que la classe est un composant de persistance Spring, activant la création automatique d'une implémentation de l'interface par Spring Data JPA.</li>
      <li><strong>JpaRepository :</strong> L'interface fournit des méthodes de base pour effectuer des opérations de CRUD sur l'entité correspondante.</li>
    </ul>
  </li>
<li><strong>Annotations liées aux services :</strong>
    <ul>
      <li><strong>@Service :</strong>Cette annotation est utilisée pour indiquer que la classe est un composant de service Spring. Elle permet à Spring de détecter automatiquement cette classe lors de la configuration de l'application. Dans ce contexte, HospitalServiceImpl est marqué comme un service, ce qui signifie qu'il contient la logique métier de l'application.</li>
      <li><strong>@Transactional:</strong> Cette annotation est utilisée pour indiquer que les méthodes de cette classe sont transactionnelles. Elle permet de gérer les transactions de base de données. Lorsqu'une méthode annotée avec @Transactional est appelée, une transaction est créée, et en cas d'exception, la transaction est annulée, assurant la cohérence des données. Cela garantit que les opérations de base de données sont atomiques.</li>
    </ul>
  </li>

  <li><strong>Annotations liées aux contrôleurs REST :</strong>
    <ul>
      <li><strong>@RestController :</strong> Marque les classes comme des contrôleurs REST, permettant d'exposer des points d'API HTTP.</li>
      <li><strong>@GetMapping :</strong> Définit les méthodes comme des gestionnaires de requêtes HTTP GET pour des chemins d'URL spécifiques.</li>
      <li><strong>@Autowired :</strong> Utilisée pour injecter automatiquement les dépendances, permettant d'accéder aux ressources nécessaires, comme les repositories, dans les contrôleurs.</li>
    </ul>
  </li>

  <li><strong>Annotation @Bean pour la Configuration des Beans :</strong>
    <ul>
      <li><strong>@Bean :</strong> Utilisée pour créer un bean personnalisé de type CommandLineRunner, gérant des dépendances, personnalisant le comportement du démarrage de l'application, centralisant la configuration, et exécutant des tâches spécifiques au lancement de l'application.</li>
    </ul>
  </li>
</ol>
<h2>Configuration de la Base de Données</h2>
Dans ce projet, une base de données H2 en mémoire est utilisée, et sa configuration est effectuée dans le fichier `application.properties`. La base de données est accessible via la console H2 avec le paramètre `spring.h2.console.enabled` activé. Cela permet une gestion aisée de la base de données 
et offre la possibilité d'interagir avec les données stockées dans l'application.</h2>

<ul>
<h3>Patient</h3>
<p>Pour créer un patient, on crée une instance de la classe Patient, on lui attribue les informations nécessaires, puis on utilise la méthode savePatient de l'interface IHospitalService pour le sauvegarder. Les patients sont associés aux rendez-vous via une relation OneToMany.</p>
<img src="captures/patient.png" alt="Patient">
<h3>Medecin</h3>
<p style="text-align: justify; text-justify: inter-word;">Pour créer un médecin, on crée une instance de la classe Medecin, on lui attribue les informations nécessaires, puis on utilise la méthode saveMedecin de l'interface IHospitalService pour le sauvegarder. Les médecins sont également associés aux rendez-vous via une relation OneToMany.</p>
<img src="captures/medecin.png" alt="Médecin">
<h3>Rendez-vous</h3>
<p style="text-align: justify; text-justify: inter-word;">La création d'un rendez-vous nécessite la définition de la date, du statut, du patient et du médecin correspondant. On utilise la méthode saveRendezVous pour sauvegarder le rendez-vous. Les rendez-vous sont liés aux patients et aux médecins via des relations ManyToOne.</p>
<img src="captures/rdv.png" alt="Rendez'vous">
<h3>Consultation</h3>
<p style="text-align: justify; text-justify: inter-word;">Pour enregistrer une consultation, on crée une instance de la classe Consultation, on attribue la date et le rapport, puis on utilise la méthode saveConsultation de l'interface IHospitalService. La consultation est associée à un rendez-vous via une relation OneToOne.</p>
<img src="captures/table_consultation.png" alt="Consultation">

<h3>Affichage de l'ID du Rendez-vous</h3>
<p style="text-align: justify; text-justify: inter-word;"> L'ID du rendez-vous récemment sauvegardé peut être affiché en imprimant la valeur de patient1.getId().
Cette expression permet d'obtenir l'identifiant attribué au rendez-vous lors de son enregistrement dans la base de données. </p>
<img src="captures/affichage.png" alt="idRDV">
</ul>
<h2>Conclusion</h2>
<p style="text-align: justify; text-justify: inter-word;">En résumé, le projet "Hospital Project" constitue une démonstration réussie de la puissance de Spring Boot pour simplifier le développement d'applications Java.
L'exploration de sa conception, de sa structure et de l'utilisation des annotations nous a permis de comprendre de nombreux aspects cruciaux liés à la création d'applications professionnelles.

La configuration de la base de données H2 en mémoire a facilité le stockage et la gestion efficaces des données tout au long du projet. De plus, la mise en place des relations entre 
les entités a illustré comment Spring Data JPA simplifie l'établissement de connexions entre les différentes entités.

Enfin, l'exposition d'une API REST pour la gestion des patients a démontré comment Spring Boot facilite le développement de points d'accès HTTP tout en permettant
le renvoi de données au format JSON, favorisant ainsi une intégration transparente avec d'autres systèmes.</p>