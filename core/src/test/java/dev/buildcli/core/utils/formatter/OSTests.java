package dev.buildcli.core.utils.formatter;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.buildcli.core.utils.OS;

public class OSTests {
    private String originalOsName;
    
        @BeforeEach
        void setUp() {
            originalOsName = System.getProperty("os.name");
        }
    
        @AfterEach
        void tearDown() throws Exception {
            System.setProperty("os.name",originalOsName);
        }
    
        @Test
    void testIsMac() throws Exception {
        System.setProperty("os.name", "Mac OS X");
        assertTrue(OS.isMac());
        assertFalse(OS.isWindows());
        assertFalse(OS.isLinux());
    }
    
    @Test
    void testIsWindows() throws Exception {
        System.setProperty("os.name", "Windows 10");
        assertTrue(OS.isWindows());
        assertFalse(OS.isMac());
        assertFalse(OS.isLinux());
    }
    
    @Test
    public void testIsLinux() throws Exception {
        System.setProperty("os.name", "Linux");
        assertFalse(OS.isWindows());
        assertFalse(OS.isMac());
        assertTrue(OS.isLinux());
    
    }
}