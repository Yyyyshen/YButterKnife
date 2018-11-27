package com.youxi.ybutterknife;

import android.app.Activity;
import android.view.View;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class YBind {

    public static void bind(Activity activity){
        bindView(activity);
        bindClick(activity);
    }

    private static void bindClick(final Activity activity) {
        Class clazz = activity.getClass();
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (final Method method:declaredMethods){
            method.setAccessible(true);
            YBindClick annotation = method.getAnnotation(YBindClick.class);
            if (annotation != null){
                int id = annotation.value();
                View view = activity.findViewById(id);
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            method.invoke(activity);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        }
    }

    private static void bindView(Activity activity) {
        Class clazz = activity.getClass();
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields){
            field.setAccessible(true);
            YBindView annotation = field.getAnnotation(YBindView.class);
            if (annotation != null){
                int id = annotation.value();
                try {
                    field.set(activity,activity.findViewById(id));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
