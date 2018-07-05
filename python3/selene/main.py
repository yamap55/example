from selene.api import *
# from selene.browsers import Browser となっているドキュメントもあるので注意
from selene.browsers import BrowserName
import time
#import wait
from selene.wait import wait_for
#from selenium.webdriver.chrome.options import Options
#
#options = Options()

# ヘッドレスモードで起動
#options.add_argument('--headless')
#options.add_argument('--no-sandbox')

# 画面サイズ指定
#options.add_argument('--window-size=1280,1024')
config.browser_name = BrowserName.CHROME
#driver = webdriver.Chrome('chromedriver', chrome_options=options)
#
#browser.set_driver(driver)

def main():
#    browser.open_url('https://todomvc4tasj.herokuapp.com')
    tasks = ss("#todo-list>li")
    active_tasks = tasks.filtered_by(have.css_class("active"))

    browser.open_url('https://todomvc4tasj.herokuapp.com')

    s("#new-todo").should(be.blank)
    print("sleep start")
    time.sleep(10)
#    wait_for(s("body").should_not(be.empty))
#    wait_for(s("#new-todo").should_not(be.empty))
#    wait_for(s("body"), be.in_dom)
    print(s("#new-todo").get_attribute("disabled"))
    print(s("#new-todo").get_attribute("placeholder"))
#    wait_for(s("#new-todo"), have.attribute("disabled","false"))
    print("sleep end")

    for task_text in ["1", "2", "3"]:
        print(task_text)
        s("#new-todo").set_value(task_text)
        s("#new-todo").press_enter()
    tasks.should(have.exact_texts("1", "2", "3")).should_each(have.css_class("active"))
    s("#todo-count").should(have.text('3'))

    tasks[2].s(".toggle").click()
    active_tasks.should(have.texts("1", "2"))
    active_tasks.should(have.size(2))

    tasks.filtered_by(have.css_class("completed")).should(have.texts("3"))

    s(by.link_text("Active")).click()
    tasks[:2].should(have.texts("1", "2"))
    tasks[2].should(be.hidden)

    s("#toggle-all").click()
    s("#clear-completed").click()
    tasks.should(be.empty)

if __name__ == '__main__':
    main()

#class TestTodoMVC(object):
#
#    def test_selene_demo(self):
#        tasks = ss("#todo-list>li")
#        active_tasks = tasks.filtered_by(have.css_class("active"))
#
#        browser.open_url('https://todomvc4tasj.herokuapp.com')
#
#        s("#new-todo").should(be.blank)
#
#        for task_text in ["1", "2", "3"]:
#            s("#new-todo").set_value(task_text).press_enter()
#        tasks.should(have.exact_texts("1", "2", "3")).should_each(have.css_class("active"))
#        s("#todo-count").should(have.text('3'))
#
#        tasks[2].s(".toggle").click()
#        active_tasks.should(have.texts("1", "2"))
#        active_tasks.should(have.size(2))
#
#        tasks.filtered_by(have.css_class("completed")).should(have.texts("3"))
#
#        s(by.link_text("Active")).click()
#        tasks[:2].should(have.texts("1", "2"))
#        tasks[2].should(be.hidden)
#
#        s("#toggle-all").click()
#        s("#clear-completed").click()
#        tasks.should(be.empty)
#
#TestTodoMVC().test_selene_demo()
