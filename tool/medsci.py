import requests
import html
import os
from bs4 import BeautifulSoup

baseUrl = "https://m.medsci.cn"  # "https://m.medsci.cn/scale/show.do?id="

headers = {
    "Host": "m.medsci.cn",
    "User-Agent": "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.146 Safari/537.36"
}


def crawle(url):
    #url=baseUrl + id
    # print(url)
    req = requests.get(url=url, headers=headers)
    html = req.text

    return html


def parse(htmlcontet):
    result = {}

    bs = BeautifulSoup(htmlcontet, 'html.parser')

    if bs.select_one("#title h2") == None:
        return None

    title = bs.select_one("#title h2").get_text(strip=True)

    # print(title)

    result["name"] = title
    result["group"] = []
    forms = bs.select("#theform tr")

    for form in forms:

        if form.has_attr("class") and "answer" in form["class"]:
            break

        if len(form.select("td")) != 2:
            continue

        if len(form.select("td:last-child input")) == 0:
            continue

        label = form.select_one("td:first-child").get_text()

        print(form)
        item = {
            "title": label,
            "option": []
        }

        result["group"].append(item)
        # print(label)
        fields = form.select("td:last-child label")
        if len(fields) == 0:
            fields = form.select("td:last-child")
        for field in fields:
            input = field.select_one("input")

            # print(field)

            type = input["type"]
            item['type'] = type

            val = "0"
            if input.has_attr("value"):
                val = input['value']

            content = html.escape(field.get_text(strip=True))

            itemId = ""

            if input.has_attr("id"):
                itemId = input["id"]
            elif input.has_attr("name"):
                itemId = input["name"]

            item["option"].append({
                "content": content,
                # "type": type,
                "value": val,
                "name": itemId
            })

            #print(type, val, content, result)
        # break
    return result


def generaeXml(dict):
    xml = '''<?xml version="1.0" encoding="utf-8"?>\n'''
    xml += f'''<Template code="{dict['name']}" title="{dict['name']}">\n'''
    xml += '''<Group>\n'''

    # for item in dict['group']:
    for i in range(len(dict['group'])):
        item = dict['group'][i]
        type = item['type']
        if type == "radio":
            type = "RadioBox"
        elif type == "checkbox":
            type = "CheckBox"
        elif type == "text":
            type = "Text"

        xml += f'''<{type} code="{str(i).zfill(2)}" title="{item['title']}" desc="{item['title']}">\n'''

        for j in range(len(item['option'])):
            option = item['option'][j]

            xml += f'''<Option code="{str(j).zfill(2) + option['name']}" text="{option['content']}" score="{option['value']}"/>\n'''

        xml += f'''</{type}>\n'''

    xml += '''</Group>\n'''
    xml += '''</Template>'''

    return xml

    # return xml


def crawleSingle(url):
    fileName = f"{url['name']}.xml"

    if(os.path.exists(fileName)):
        return

    print(f"开始抓取：{url['name']}")

    htmlContent = crawle(url["url"])
    dict = parse(htmlContent)
    if dict == None:
        return

    xml = generaeXml(dict)

    f = open(fileName, "w", encoding="utf-8")
    f.write(xml)
    f.close()


def crawleList(id, page):
    dirs = f"{id}/{page}"
    if not os.path.exists(dirs):
        os.makedirs(dirs)

    url = baseUrl + f"/scale/list.do?page={page}&s_id={id}"
    htmlcontet = crawle(url)

    # print(htmlcontet)
    bs = BeautifulSoup(htmlcontet, 'html.parser')

    elements = bs.select("#list_wrap .news_list a")
    for element in elements:

        # print(element.get_text(strip=True))
        yield {
            "name": f"{dirs}/" + element.get_text(strip=True).replace("/", "_"),
            "url": baseUrl + element['href']
        }


for url in crawleList("17", "1"):
    crawleSingle(url)


#crawleSingle( { "name": "test.xml", "url": "https://m.medsci.cn/scale/show.do?id=1eae65b" })
