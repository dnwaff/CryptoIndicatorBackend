import requests
from bs4 import BeautifulSoup

headers= requests.utils.default_headers()
headers.update({
    'User-Agent': 'Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:52.0) Gecko/20100101 Firefox/52.0',
})
ticker = 'THETUSD'
url = "https://www.barchart.com/crypto/quotes/%5E{0}/opinion".format(ticker)
try:
    page = requests.get(url, headers=headers)
    soup = BeautifulSoup(page.content, "html.parser")
    overall_average_div = soup.find('div', class_="opinion-status")
    percent = overall_average_div.find('span', class_='opinion-percent').contents[0]
    buy_sell = overall_average_div.find('span', class_='opinion-signal').contents[0]
    print(percent, buy_sell)
except Exception:
    print('ran into an issue')



