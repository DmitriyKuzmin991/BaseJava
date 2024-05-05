package model;

import java.time.LocalDate;
import java.util.List;

public class ResumeTestData {
    public static void main(String[] args) {
        Resume r = new Resume("Григорий Кислин");
        r.setContacts(List.of(
                new Contact(ContactType.PHONENUMBER, "+7(921) 855-0482"),
                new Contact(ContactType.SKYPE, "grigory.kislin"),
                new Contact(ContactType.EMAIL, "gkislin@yandex.ru"),
                new Contact(ContactType.PROFILE, "LinkedIn"),
                new Contact(ContactType.PROFILE, "GitHub"),
                new Contact(ContactType.PROFILE, "Stackoverflow"),
                new Contact(ContactType.HOMEPAGE, "Домашняя страница")
        ));
        r.setBody(SectionType.OBJECTIVE, new TextSection("Ведущий стажировок и корпоративного обучения " +
                "по Java Web и Enterprise технологиям"));
        r.setBody(SectionType.PERSONAL, new TextSection("Аналитический склад ума, сильная логика," +
                " креативность, инициативность. Пурист кода и архитектуры."));
        r.setBody(SectionType.ACHIEVEMENT, new ListSection(List.of(
                "Организация команды и успешная реализация Java проектов для сторонних заказчиков: приложения автопарк на стеке Spring Cloud/микросервисы, система мониторинга показателей спортсменов на Spring Boot, участие в проекте МЭШ на Play-2, многомодульный Spring Boot + Vaadin проект для комплексных DIY смет",
                "С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 3500 выпускников.",
                "Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.",
                "Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера.",
                "Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга.",
                "Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов (SOA-base архитектура, JAX-WS, JMS, AS Glassfish). Сбор статистики сервисов и информации о состоянии через систему мониторинга Nagios. Реализация онлайн клиента для администрирования и мониторинга системы по JMX (Jython/ Django).",
                "Реализация протоколов по приему платежей всех основных платежных системы России (Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа."
        )));
        r.setBody(SectionType.QUALIFICATIONS, new ListSection(List.of(
                "JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2",
                "Version control: Subversion, Git, Mercury, ClearCase, Perforce",
                "DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle, MySQL, SQLite, MS SQL, HSQLDB",
                "Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy",
                "XML/XSD/XSLT, SQL, C/C++, Unix shell scripts",
                "Java Frameworks: Java 8 (Time API, Streams), Guava, Java Executor, MyBatis, Spring (MVC, Security, Data, Clouds, Boot), JPA (Hibernate, EclipseLink), Guice, GWT(SmartGWT, ExtGWT/GXT), Vaadin, Jasperreports, Apache Commons, Eclipse SWT, JUnit, Selenium (htmlelements).",
                "Python: Django.",
                "JavaScript: jQuery, ExtJS, Bootstrap.js, underscore.js",
                "Scala: SBT, Play2, Specs2, Anorm, Spray, Akka",
                "Технологии: Servlet, JSP/JSTL, JAX-WS, REST, EJB, RMI, JMS, JavaMail, JAXB, StAX, SAX, DOM, XSLT, MDB, JMX, JDBC, JPA, JNDI, JAAS, SOAP, AJAX, Commet, HTML5, ESB, CMIS, BPMN2, LDAP, OAuth1, OAuth2, JWT.",
                "Инструменты: Maven + plugin development, Gradle, настройка Ngnix",
                "администрирование Hudson/Jenkins, Ant + custom task, SoapUI, JPublisher, Flyway, Nagios, iReport, OpenCmis, Bonita, pgBouncer",
                "Отличное знание и опыт применения концепций ООП, SOA, шаблонов проектрирования, архитектурных шаблонов, UML, функционального программирования",
                "Родной русский, английский \"upper intermediate\""
        )));
        Company comp1 = new Company("Java Online Projects","",List.of(
                new WorkPeriod("Автор проекта",
                        "Создание, организация и проведение Java онлайн проектов и стажировок.",
                        LocalDate.of(2013,10,1),LocalDate.now()
                        )));
        Company comp2 = new Company("Wrike", "",List.of(
                new WorkPeriod("Старший разработчик (backend)",
                        "Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO.",
                        LocalDate.of(2014,10,1),LocalDate.of(2016,1,1)
                )));
        Company comp3 = new Company("RIT Center", "",List.of(
                new WorkPeriod("Java архитектор",
                        "Организация процесса разработки системы ERP для разных окружений: релизная политика, версионирование, ведение CI (Jenkins), миграция базы (кастомизация Flyway), конфигурирование системы (pgBoucer, Nginx), AAA via SSO. Архитектура БД и серверной части системы. Разработка интергационных сервисов: CMIS, BPMN2, 1C (WebServices), сервисов общего назначения (почта, экспорт в pdf, doc, html). Интеграция Alfresco JLAN для online редактирование из браузера документов MS Office. Maven + plugin development, Ant, Apache Commons, Spring security, Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, Unix shell remote scripting via ssh tunnels, PL/Python",
                        LocalDate.of(2012,4,1),LocalDate.of(2014,10,1)
                )));
        Company comp4 = new Company("Luxoft (Deutsche Bank)", "",List.of(
                new WorkPeriod("Ведущий программист",
                        "Участие в проекте Deutsche Bank CRM (WebLogic, Hibernate, Spring, Spring MVC, SmartGWT, GWT, Jasper, Oracle). Реализация клиентской и серверной части CRM. Реализация RIA-приложения для администрирования, мониторинга и анализа результатов в области алгоритмического трейдинга. JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Highstock, Commet, HTML5.",
                        LocalDate.of(2010,12,1),LocalDate.of(2012, 4,1)
                )));
        Company comp5 = new Company("Yota", "",List.of(
                new WorkPeriod("Ведущий специалист",
                        "Дизайн и имплементация Java EE фреймворка для отдела \"Платежные Системы\" (GlassFish v2.1, v3, OC4J, EJB3, JAX-WS RI 2.1, Servlet 2.4, JSP, JMX, JMS, Maven2). Реализация администрирования, статистики и мониторинга фреймворка. Разработка online JMX клиента (Python/ Jython, Django, ExtJS)",
                        LocalDate.of(2008,6,1),LocalDate.of(2010,12,1)
                )));
        Company comp6 = new Company("Enkata", "",List.of(
                new WorkPeriod("Разработчик ПО",
                        "Реализация клиентской (Eclipse RCP) и серверной (JBoss 4.2, Hibernate 3.0, Tomcat, JMS) частей кластерного J2EE приложения (OLAP, Data mining).",
                        LocalDate.of(2007,3,1),LocalDate.of(2008,6,1)
                )));
        Company comp7 = new Company("Siemens AG", "",List.of(
                new WorkPeriod("Разработчик ПО",
                        "Разработка информационной модели, проектирование интерфейсов, реализация и отладка ПО на мобильной IN платформе Siemens @vantage (Java, Unix).",
                        LocalDate.of(2005,1,1),LocalDate.of(2007,2,1)
                )));
        Company comp8 = new Company("Alcatel", "",List.of(
                new WorkPeriod("Инженер по аппаратному и программному тестированию",
                        "Тестирование, отладка, внедрение ПО цифровой телефонной станции Alcatel 1000 S12 (CHILL, ASM).",
                        LocalDate.of(1997,9,1),LocalDate.of(2005,1,1)
                )));
        CompanySection companySection = new CompanySection();
        companySection.addCompany(comp1);
        companySection.addCompany(comp2);
        companySection.addCompany(comp3);
        companySection.addCompany(comp4);
        companySection.addCompany(comp5);
        companySection.addCompany(comp6);
        companySection.addCompany(comp7);
        companySection.addCompany(comp8);
        r.setBody(SectionType.EXPERIENCE, companySection);
        CompanySection companySection2 = new CompanySection();
        Company education = new Company("Coursera", "",List.of(
                new WorkPeriod("'Functional Programming Principles in Scala' by Martin Odersky",
                        "",
                        LocalDate.of(2013,3,1),LocalDate.of(2013,5,1)
                )));
        Company education2 = new Company("Luxoft", "",List.of(
                new WorkPeriod("Курс 'Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.'",
                        "",
                        LocalDate.of(2011,3,1),LocalDate.of(2011,4,1)
                )));
        Company education3 = new Company("Siemens AG", "",List.of(
                new WorkPeriod("3 месяца обучения мобильным IN сетям (Берлин)",
                        "",
                        LocalDate.of(2005,1,1),LocalDate.of(2005,4,1)
                )));
        companySection2.addCompany(education);
        companySection2.addCompany(education2);
        companySection2.addCompany(education3);
        r.setBody(SectionType.EDUCATION, companySection2);
        r.printResume();
    }
}
