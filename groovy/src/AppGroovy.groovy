/**
 * Created by feshfans on 2016/7/31.
 * @email feshfans@163.com
 */

Book book=new Book('Groovy in action2')
println(book.title)

def bookBean=new BookBean()
bookBean.title='what is groovy'
println(bookBean.title)

bookBean.setTitle("how to use groovy")
println(bookBean.getTitle())

def firstName='kang'
def lastName='hui lai'
println("$firstName $lastName")

println(1.plus(3))

Integer integer=4
def i=4
println( i==integer)

def range=0..10
println(range.contains(5))
range=new IntRange(0,10)
println(range.contains(11))

println(range instanceof Range)

def today=new Date()
def yesterday=today-1
println((yesterday..today).size())

println(('a'..'c').contains('c'))

def log=''
(9..<5).each {element->
    log+=element
}
println(log)

range.isCase()

println('==============================list')
def list=[1,2,3]
println(list.size())
println(list instanceof ArrayList)