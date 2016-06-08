package com.kang.processor;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.util.Set;

/**
 * Created by kang on 16-5-12.
 */
@SupportedSourceVersion(SourceVersion.RELEASE_6)
@SupportedAnnotationTypes("com.kang.annotation.PrintMe")
public class PrintMeProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {

        Messager messager= processingEnv.getMessager();
        messager.printMessage(Diagnostic.Kind.NOTE,"test================");
        for(TypeElement element:annotations){
            for(Element e:roundEnv.getElementsAnnotatedWith(element)){
                messager.printMessage(Diagnostic.Kind.NOTE,"Printint:"+e.toString());

            }
        }
        return true;
    }
}
