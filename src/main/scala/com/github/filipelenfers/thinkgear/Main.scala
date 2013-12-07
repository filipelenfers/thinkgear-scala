package com.github.filipelenfers.thinkgear


object Main {

	def main(args: Array[String]): Unit = {
		val iter = new ThinkgearIterator(new ThinkgearConnector)

		for( i <- 0 to 10) {
			val input = iter.next
			println(input)
		}
	}
	
}