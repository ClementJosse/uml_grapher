package fr.lernejo;

import fr.lernejo.umlgrapher.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class UmlGraphTests {

    @Test
    void empty_interface_with_no_relation() {

        Class[] classes = new Class[]{Machin.class};
        UmlGraph graph = new UmlGraph(classes);

        String output = graph.as(GraphType.Mermaid);

        Assertions.assertThat(output).isEqualTo("""
            classDiagram
            class Machin {
                <<interface>>
            }
            """);

    }

    @Test
    void no_class_no_interface() {

        Class[] classes = new Class[]{};
        UmlGraph graph = new UmlGraph(classes);

        String output = graph.as(GraphType.Mermaid);

        Assertions.assertThat(output).isEqualTo("""
            classDiagram""");

    }

    @Test
    void multiple_interfaces_with_no_relation() {

        Class[] classes = new Class[]{Machin.class, Truc.class};
        UmlGraph graph = new UmlGraph(classes);

        String output = graph.as(GraphType.Mermaid);

        Assertions.assertThat(output).isEqualTo("""
            classDiagram
            class Machin {
                <<interface>>
            }
            
            class Truc {
                <<interface>>
            }
            """);

    }

    interface Machin {
    }

    interface Truc{
    }


}
