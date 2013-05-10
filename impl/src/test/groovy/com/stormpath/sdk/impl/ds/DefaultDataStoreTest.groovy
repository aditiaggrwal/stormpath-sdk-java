package com.stormpath.sdk.impl.http

import org.testng.annotations.Test
import static org.testng.Assert.assertEquals

import com.stormpath.sdk.impl.error.DefaultError;
import com.stormpath.sdk.impl.http.*;
import com.stormpath.sdk.impl.http.support.DefaultRequest;
import com.stormpath.sdk.impl.http.support.Version;
import com.stormpath.sdk.impl.resource.AbstractResource;
import com.stormpath.sdk.impl.util.Assert;
import com.stormpath.sdk.impl.util.StringInputStream;
import com.stormpath.sdk.impl.util.StringUtils;
import com.stormpath.sdk.resource.Resource;
import com.stormpath.sdk.resource.ResourceException;
import com.stormpath.sdk.resource.Saveable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.*;

class DefaultDataStoreTest {

  @Test
  void testSave() {
    //Testing to see if the argument is null. 
    //If null, save should throw an error and pass the test. If not, fail.
    try {
      save(null)
      fail("This should have failed", e)  
    } catch(e) {}
    
    try {
      def res = Resource()
      save(res)
      fail("This should have failed", e)  
    } catch(e) {}
    
    //Testing to see if the argument is the correct class. 
    //If not correct class, save should throw an error and pass the test. If not, fail.
    try {
      def lhMap = LinkedHashMap<String, Object>
      save(lhMap)
      fail("This is not of the AbstractResource class", e)
    } catch(e) {}
    
    try {
      def map = Map<String, Object>
      save(map)
      fail("This is not of the Saveable class", e)
    } catch(e) {}
    
    try {
      def s = Saveable()
      save(s)
      fail("This is not of the Saveable class", e)
    } catch(e) {}
    
    try {
      def ar = AbstractResource()
      save(ar)
      fail("This is not of the AbstractResource class", e)
    } catch(e) {}
   
    //Checking to see if the qualify method works
    //Also checks to see if save has only been called on objects that have been persisted
    def r = Resource() 
    def href = r.setHref("www.google.com") 
    save(r)
    assertEquals r.getHref(), "/www.google.com"
 
    def newRes = Resource()
    def href = r.setHref("http://abc")
    save(newRes)
    assertEquals newRes.getHref(), "http://abc" 
    
    try {
      def newRes2 = Resource()
      save(newRes2)
      fail("This does not have an href", e)
    } catch(e) {}
  
  }


  //Testing the delete function  
  @Test
  void testDelete() {
    //Testing to see if the argument is null. 
    //If null, save should throw an error and pass the test. If not, fail.
    try {
      save(null)
      fail("This should have failed", e)  
    } catch(e) {}
    
    try {
      def res = Resource()
      save(res)
      fail("This should have failed", e)  
    } catch(e) {}
    
    //Testing to see if the argument is the correct class. 
    //If not correct class, save should throw an error and pass the test. If not, fail.
    try {
      def lhMap = LinkedHashMap<String, Object>
      save(lhMap)
      fail("This is not of the AbstractResource class", e)
    } catch(e) {}
  
    try {
      def ar = AbstractResource()
      save(ar)
      fail("This is not of the AbstractResource class", e)
    } catch(e) {}
    
  }
  
}