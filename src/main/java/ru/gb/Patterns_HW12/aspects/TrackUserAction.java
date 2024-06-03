package ru.gb.Patterns_HW12.aspects;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
public @interface TrackUserAction {
}