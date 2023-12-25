package pl.piomin.sample.spring.graphql.service;

import org.python.core.PyInteger;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.*;

@Service
public class Neuro {
    @PostConstruct
    public void init() throws IOException, ScriptException {

    }
}
