###1. Goals
In this lesson, we'll focus on understanding the concept of Dependency Injection (DI) and how this work in Spring.



###2. Lesson Notes


#2.1. What is a Dependency?
Before we can talk about Dependency Injection, let’s first define what a dependency is.

Understanding this concept is critical not only for Spring, but for developing software in general.

Let’s focus on the Java ecosystem and put forward a simple definition:

Class A has a dependency on Class B when it interacts with it in any way



###2.2. Dependency Injection
The way Class A will get access to that Class B dependency is critical here.

One option is for Class A to take on the responsibility of instantiating B by itself:

JAVA
public class A {
    private B bDependency;
  
    public A() {
        bDependency = new B();    
    }
}
Alternatively, that responsibility can be external, meaning the dependency comes from the outside:

JAVA
public class A {
    private B bDependency;
    
    public A(B bDependency) {
        this.bDependency = bDependency;
    }
}
That is, in a nutshell, Dependency Injection (not to be confused with the the Dependency Inversion principle from SOLID).

Injection is simply the process of injecting the dependency B in the object of type A.

Now, since the instantiation of the B dependency is no longer done in A, that responsibility will now belong to the framework.



###2.3. Why DI
Separating the responsibility of instantiating a class from the logic in that class is a very useful concept.

This leads to a more loosely coupled system and to a lot of flexibility in the design of that system, as now the dependency can be decided (or swapped out) at runtime.

This can be very helpful in both application architecture, as well as testing, because DI make it easier to switch between different implementations of the dependency. For example, we can pass in a mock of a dependency rather than a full dependency object.



###2.4. Types of Injection
There are essentially three ways to inject a dependency: 

via the raw field
via the constructor
via a setter
These all have their advantages and disadvantages, and we’ll look into each in detail throughout the course.



###2.5. The Spring IoC Container
Dependency Injection is a technique that’s part of the broader Inversion of Control (IoC) principle.

We won't go into detail here about IoC, but have a look at the resources section for more information on it.

Now that we understand the concepts and principles, let’s touch on what Spring does as well. Simply put, Spring has the responsibility of creating and configuring the dependencies and injecting them where needed.

We’ll discuss the Spring IOC Container further in the next lesson.



###3. Resources
- Inversion of Control and Dependency Injection with Spring

- Inversion of Control Containers and the Dependency Injection pattern (Martin Fowler)

- Spring Dependency Injection Series

   Lesson 2: The Basics of Java Configuration and the Spring Context
1. Goals
In this lesson, we'll discuss the main Spring IoC container - the Spring Application Context.



###2. Lesson Notes
The relevant module you need to import when you're starting with this lesson is: m2-basics-of-java-configuration-and-the-spring-context-start

If you want have a look at the fully implemented lesson, as a reference, feel free to import: m2-basics-of-java-configuration-and-the-spring-context-end



###2.1. Spring Application Context
We previously discussed the Spring IOC Container - which, simply put, will create the objects, wire them together, configure them, and manage their complete lifecycle.

The framework comes with multiple container implementations. To keep things very simple at this early stage, we'll discuss the main one - the Spring Application Context.

When the Spring application starts up, this Application Context bootstrapps and starts instantiating the objects called beans in Spring terminology.

Let's start with a practical example of defining a bean manually. This will make understanding the concept of the Application Context more concrete.



###2.2. Contributing Beans to the Context
We can create beans in several ways that we'll discuss throughout the course.

But, for this example, we’ll use a simple and highly common option: a configuration class where we manually define a bean.

Let's create a new PersistenceConfig class:

JAVA
@Configuration
public class PersistenceConfig {

    @Bean
    public ProjectRepositoryImpl projectRepository() {
        return new ProjectRepositoryImpl();
    }

}
We've also defined a projectRepository bean using the simple @Bean annotation.

Before we go into more detail on this, let’s run/debug the application and understand how the Spring Application Context gets bootstrapped and how the bean we just defined is part of that process.

We’re going to set a breakpoint in the bean definition here and debug. By doing this, we can see the bootstrapping process run, and, eventually, hit our configuration and create our bean.

Now that we’ve seen it working, let’s take a step back and understand what’s going on.

The @Configuration annotation indicates to Spring that this class needs to be processed by the container because it will contribute bean definitions to it.

And, of course, the @Bean annotation is one such actual bean definition. In our case, this is a bean named projectRepository, as that’s the name of the method.

Now we've started to get some context around how to framework works and lay the groundwork for going deeper into beans and Dependency Injection.



##3. Resources
- Spring Application Context

- Java-based Container Configuration



   Lesson 3: Defining Beans, Component Scanning and Bean Annotations
1. Goals
In this lesson, we'll focus on how to define beans in Spring and discover them using component scanning.



2. Lesson Notes
The relevant module you need to import when you're starting with this lesson is: m2-defining-beans-component-scanning-and-bean-annotations-start

If you want have a look at the fully implemented lesson, as a reference, feel free to import: m2-defining-beans-component-scanning-and-bean-annotations-end



2.1. Spring Component Scanning
At this point, we’re starting to understand the Spring application context and how we can add new beans to it using a @Configuration class and the @Bean annotation.

Now, let’s see how we can move from explicitly defining a bean to letting the context discover that bean on its own.

This is called component scanning, and it's a different technique of achieving the same thing: adding beans into the context.

As it's common in Spring, this can be achieved with the help of annotations. More specifically, the @ComponentScan annotation. Then, for the classes we want to define as beans, we can use stereotype annotations.

The simplest stereotype annotation we can use is @Component. Basically, during the bootstrapping process, Spring will scan for any classes annotated with @Component and will instantiate them as beans.

Let’s open up the ProjectRepositoryImpl and let’s annotate it:

JAVA
@Component
public class ProjectRepositoryImpl implements IProjectRepository {
    // ...
}
We’re now expecting this to be picked up as a bean.

We can add a breakpoint in the constructor here and start up the application, to verify that the breakpoint is hit.

This way, we can see that component scanning is working as we expected.

Note that we never actually defined component scanning explicitly. This is because @SpringBootApplication is already using the annotation.

If we go to the @SpringBootApplication definition, we'll see that is includes the @ComponentScan annotation.

By default, this scans classes in the same package or below. In our case, this is the com.baeldung.ls package and all the packages below it.

If we want to scan a specific package, we can specify it using the basePackages attribute.

Let’s add a new PersistenceConfig class that uses @ComponentScan to scan only the com.baeldung.ls.persistence package:

JAVA
@Configuration
@ComponentScan(basePackages= {"com.baeldung.ls.persistence"})
public class PersistenceConfig {
    // 
}
2.2. Other Stereotype Annotations
Besides @Component, there are, a few more stereotype annotations that aren’t actually that different. They use @Component under the hood and just bring an extra layer of semantics on top.

For example, on the ProjectRepositoryImpl we can replace @Component with the @Repository annotation:

JAVA
@Repository
public class ProjectRepositoryImpl implements IProjectRepository {
    // ...
}
Nothing changes technically, but this fits better the exact semantics of this particular bean, since it's actually a repository.

Similarly, we can use the @Service annotation for the ProjectServiceImpl:

JAVA
@Service
public class ProjectServiceImpl implements IProjectService {
    // ...
}
2.3. Advantages and Disadvantages
Finally, one quick note about this style of annotation-based Java configuration: as opposed to the more explicit configuration we explored earlier, and even compared to the older-style XML-based configuration, this has the important advantage of simplicity.

However, wherever a process changes from explicit to implicit there’s also a disadvantage. And that is that we’re losing the clean separation between the business logic (the beans) and the configuration of those beans.

That’s typically an acceptable tradeoff, but it’s worth understanding.



3. Resources
- Spring Component Scanning

- @Component vs @Repository and @Service in Spring

- Spring Bean Annotations



   Lesson 4: Lifecycle of a Bean - Init and Destroy Hooks
1. Goals
In this lesson, we'll go through the basic concepts of the bean lifecycle in Spring.



2. Lesson Notes
The relevant module you need to import when you're starting with this lesson is: m2-lifecycle-of-a-bean-start

If you want have a look at the fully implemented lesson, as a reference, feel free to import: m2-lifecycle-of-a-bean-end



2.1. Bean Lifecycle Phases
Basically, the lifecycle of a Spring bean consists of 3 phases:

initialization phase
use phase
destroy phase
In this lesson, we’ll focus on the initialization and destroy phases, as they’re the most interesting ones from the point of view of dependency injection.

Our goal here is to understand not only the lifecycle, but also the hooks in the framework connected to that lifecycle.

Of course, the use phase is a phase in which an application normally spends the most of its time, and it’s the point of interest for the business logic.



2.2. Initialization Phase
This phase consists of two main stages:

loading bean definitions
instantiating beans
Let’s create a first bean in the AppConfig class:

JAVA
@Bean
public BeanA beanA() {
    return new BeanA();
}
Let’s look at first hook that Spring provides to customize the bean creation. Spring will run methods annotated with @PostConstruct only once, just after the initialization of the bean properties.

Let’s add this method to the BeanA definition:

JAVA
@PostConstruct
public void post() {
    // 
}
We can debug the application to make sure this gets called correctly.

Next, let’s explore a similar hook which works when we’re using the @Bean annotation to define a bean.

First, let’s create our new bean - BeanB and let’s provide it with a simple initialize method:

JAVA
public class BeanB {

    public void initialize() {
        log.info("Custom initializer is called.");
    }
}
Now let’s define this as a bean, using the @Bean annotation and add an optional param of the annotation called initMethod:

JAVA
@Bean(initMethod="initialize")
public BeanB beanB() {
    return new BeanB();
}
This is very useful when we want to keep configuration out of our domain logic because, notice, BeanB is now entirely clean of any framework code.

So far, we’ve seen how to customize the bean initialization using @PostConstruct and @Bean(initMethod=”..”). However, these are not the only possibilities. We’ll explore other options, like the InitializingBean interface in other lessons.

The use phase is the phase in which normally an application lives the most of its time. The other lessons of the course consider this phase in full details. Therefore, let's go to the next phase.



2.3. Destroy Phase
This is the final phase of an application. It’s activated when the application context becomes eligible for garbage collection.

At this point, all the beans get out of scope of the application and become eligible for garbage collection.

The destroy options are very similar to the initialization options we already explored.

First, we have the @PreDestroy annotation that we can add on a bean method, to indicate that method should be executed before the bean is destroyed:

JAVA
public class BeanC {
  
    private static Logger log = LoggerFactory.getLogger(BeanC.class);

    @PreDestroy
    public void preDestroy() {
        log.info("@PreDestroy annotated method is called.");
    }

    public void destroy() {
        log.info("Custom destroy method is called.");
    }
}
Similarly, we can use the destroyMethod attribute of the @Bean annotation to specify the destroy() method we added above:

JAVA
@Bean(destroyMethod="destroy")
public BeanC beanC() {
    return new BeanC();
}
To activate this phase, let’s modify the main method:

JAVA
public static void main(final String... args) {
    ConfigurableApplicationContext context = SpringApplication.run(new Class[]{LsApp.class, Config.class}, args);
    context.close();
}


3. Resources
- Spring PostConstruct and PreDestroy Annotations 

   Lesson 5: Simple Wiring and Injection - part 1
1. Goals
In this lesson, we'll have a look at how to wire beans together using Dependency Injection.



2. Lesson Notes
The relevant module you need to import when you're starting with this lesson is: m2-simple-wiring-and-injection-start

If you want have a look at the fully implemented lesson, as a reference, feel free to import: m2-simple-wiring-and-injection-end



2.1. Dependency Injection
Now that we have a good understanding of how to create beans and make sure they get into the the Application Context, let’s have a look at defining relations between these beans

We talked about this in a general way when we first introduced DI. Let’s make that more concrete and see how we can set up a dependency between two beans.

The container injects the dependencies for us, but we have to define those dependencies.

There are primarily three ways to define or inject dependencies:

constructor injection
setter injection
field injection


2.2. Constructor-Based DI
In constructor-based injection we inject dependencies in a class via its constructor arguments. Each constructor argument represents a dependency.

Spring will inject those dependencies in our class automatically.

Let’s take our ProjectServiceImpl class as an example and inject IProjectRepository in this class via a constructor argument:

JAVA
@Service
public class ProjectServiceImpl implements IProjectService {

    private IProjectRepository projectRepository;

    public ProjectServiceImpl(IProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }
    
    // ...
}
The Spring container will fetch the projectRepository bean for us and inject it in our service class.

Note that since we have a single constructor, the @Autowired annotation is optional.

If we define more than one constructor and we want one of them to inject dependencies on creating the bean, then we need to add @Autowired on the required constructor.

Overall, constructor based dependency injection is clean and doesn't introduce any container specific classes, annotations or other dependencies.



2.3. Setter-Based DI
In setter-based injection, we inject dependencies using the setter methods of the required dependencies declared as fields.

Let’s create a new service class implementation that will inject the repository dependency using setter injection:

JAVA
public class ProjectServiceImplSetterInjection implements IProjectService {

    private IProjectRepository projectRepository;
    
    @Autowired
    public void setProjectRepository(IProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }
    
    // ...
}
The setProjectRepository setter will be used to inject the appropriate projectRepository bean in our class using the @Autowired annotation added to the setter.

Next, let’s define the service in our configuration class AppConfig:

JAVA
@Configuration
public class LsAppConfig {

    @Bean
    public IProjectService projectServiceImplSetterInjection() {
        return new ProjectServiceImplSetterInjection();
    }
}
The container will inject the projectRepository dependency after calling the service constructor.



2.4. Field-Based DI
In field-based dependency injection we inject dependencies using the @Autowired annotation directly on fields.

Let’s create a new service class implementation that will inject the repository dependency using @Autowired:

JAVA
@Service
public class ProjectServiceImplAutowiring implements IProjectService {

    @Autowired
    private IProjectRepository projectRepository;
    
    // ...
}
This is all we need to do. The Spring container will fetch the appropriate bean projectRepository and inject it in our service class.

The default way @Autowired works is it matches the bean by-type, i.e. it will fetch the bean of type IProjectRepository and inject it in our class.

Next, we'll see what happens if we’re trying to inject a bean by interface and we have multiple candidate beans that implement that interface.

   Lesson 5: Simple Wiring and Injection - part 2
2.5. @Qualifier
Let's see what would happen if we had two repositories that implement our project repository interface.

We'll add a second implementation of the ProjectRepository interface, similar to the first one, named ProjectRepositoryImpl2.

If we try to run the project now, the startup will fail, with a helpful error message, that shows us exactly what the issue is:

"Parameter 0 of constructor in com.baeldung.ls.service.impl.ProjectServiceImpl required a single bean, but 2 were found."

The framework also gives us a suggestion for how to fix the problem: either making one of the beans primary, or using the @Qualifier annotation.

If there are multiple beans of a type, then we can control the specific bean that we have to inject by using the additional @Qualifier annotation and give it the specific bean name to inject:

JAVA
@Service
public class ProjectServiceImpl implements IProjectService {

    private IProjectRepository projectRepository;

    public ProjectServiceImpl(@Qualifier("projectRepositoryImpl2") IProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }
    
    //...
}
3. Resources
- Intro to Inversion of Control and Dependency Injection with Spring 

- Guide to Spring @Autowired

