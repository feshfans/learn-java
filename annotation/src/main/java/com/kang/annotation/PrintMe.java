package com.kang.annotation;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by kang on 16-5-12.
 */
@Retention(RetentionPolicy.CLASS)
@SupportedSourceVersion(SourceVersion.RELEASE_6)
public @interface PrintMe {



}
