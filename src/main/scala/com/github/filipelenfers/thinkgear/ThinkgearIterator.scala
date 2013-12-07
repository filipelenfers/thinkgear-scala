package com.github.filipelenfers.thinkgear

import java.io.OutputStreamWriter
import java.net.Socket
import java.io.BufferedReader
import java.io.InputStreamReader
import net.liftweb.json._

class ThinkgearIterator(val tgConnector: ThinkgearConnector) extends Iterator[ThinkgearResponse] {
  
  def hasNext = true
  
  def next =  JsonParser.parse(tgConnector.readLine)
}

class ThinkgearConnector(val rawOutput: Boolean = false, val host: String = "127.0.0.1", val port: Int = 13854) {

  val tgSocket = new Socket(host, port)
  val tgInput = new BufferedReader(new InputStreamReader(tgSocket.getInputStream))
  val tgOutput = new OutputStreamWriter(tgSocket.getOutputStream)

  def jsonConfiguration = compact(render(JObject(JField("enableRawOutput",JBool(rawOutput)) :: JField("format",JString("Json"))  :: Nil)))

  def configure() = {
    tgOutput.write(jsonConfiguration)
    tgOutput.flush()
  }

  def readLine = tgInput.readLine

  configure()
}