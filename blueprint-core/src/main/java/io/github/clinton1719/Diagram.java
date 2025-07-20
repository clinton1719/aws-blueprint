package io.github.clinton1719;

import guru.nidi.graphviz.attribute.Color;
import guru.nidi.graphviz.attribute.Style;
import guru.nidi.graphviz.engine.Format;
import guru.nidi.graphviz.engine.Graphviz;
import guru.nidi.graphviz.model.Graph;
import guru.nidi.graphviz.model.Node;

import java.io.File;

import static guru.nidi.graphviz.model.Factory.*;

public class Diagram {

    public static void main(String[] args) throws Exception {
        Node ec2 = node("EC2").with(Color.BLUE);
        Node rds = node("RDS").with(Color.RED, Style.DOTTED);

        Graph g = graph("aws").directed().with(ec2.link(rds));

        Graphviz.fromGraph(g).render(Format.SVG).toFile(new File("blueprint-diagram.svg"));
        System.out.println("Generated: blueprint-diagram.svg");
    }
}

