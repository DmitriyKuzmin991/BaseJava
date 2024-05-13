package utils;

import model.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Map;

public class ResumeTestData {
    public static void main(String[] args) {
        System.out.println(getTestResume("uuid1", "Dmitriy"));
    }

    public static Resume getTestResume(String uuid, String fullName) {
        Resume resume = new Resume(uuid, fullName);
        resume.setContacts(Map.of(
                ContactType.PHONE, "+7(921) 855-0482",
                ContactType.SKYPE, "grigory.kislin",
                ContactType.EMAIL, "gkislin@yandex.ru",
                ContactType.LINKEDIN, "LinkedIn",
                ContactType.GITHUB, "GitHub",
                ContactType.STACKOVERFLOW, "Stackoverflow",
                ContactType.HOMEPAGE, "Домашняя страница"
        ));
        resume.setSections(SectionType.OBJECTIVE, new TextSection(
                "Ведущий стажировок и корпоративного обучения " +
                        "по Java Web и Enterprise технологиям"));
        resume.setSections(SectionType.PERSONAL, new TextSection(
                "Аналитический склад ума, сильная логика," +
                        " креативность, инициативность. Пурист кода и архитектуры."));
        resume.setSections(SectionType.ACHIEVEMENT, new ListSection(List.of(
                "Организация команды и успешная реализация Java проектов для сторонних заказчиков: приложения автопарк на стеке Spring Cloud/микросервисы, система мониторинга показателей спортсменов на Spring Boot, участие в проекте МЭШ на Play-2, многомодульный Spring Boot + Vaadin проект для комплексных DIY смет",
                "С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 3500 выпускников.",
                "Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.",
                "Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера.",
                "Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга.",
                "Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов (SOA-base архитектура, JAX-WS, JMS, AS Glassfish). Сбор статистики сервисов и информации о состоянии через систему мониторинга Nagios. Реализация онлайн клиента для администрирования и мониторинга системы по JMX (Jython/ Django).",
                "Реализация протоколов по приему платежей всех основных платежных системы России (Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа."
        )));
        resume.setSections(SectionType.QUALIFICATIONS, new ListSection(List.of(
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
        resume.setSections(SectionType.EXPERIENCE, new CompanySection(List.of(
                new Company("Java Online Projects", null, List.of(
                        new Period("Автор проекта", "Создание, организация и проведения ava онлайн проектов и стажировок.",
                                DateUtil.of(2013, Month.OCTOBER), LocalDate.now()))),
                new Company("Wrike", null, List.of(
                        new Period("Старший разработчик (backend)", "Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO.\"",
                                DateUtil.of(2014, Month.OCTOBER), DateUtil.of(2016, Month.JANUARY))))
        )));
        resume.setSections(SectionType.EDUCATION, new CompanySection(List.of(
                new Company("Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики", null, List.of(
                        new Period("Инженер (программист Fortran, C)",null, DateUtil.of(1987,Month.JULY), DateUtil.of(1993,Month.JULY)),
                        new Period("Аспирантура (программист С, С++)", null, DateUtil.of(1993,Month.SEPTEMBER), DateUtil.of(1996,Month.JULY))
                ))
        )));
        return resume;
    }
}

