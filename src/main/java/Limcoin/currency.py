import requests,json

#resp = requests.get('https://free.currconv.com/api/v7/convert?q=USD_GBP,EUR_GBP&compact=ultra&apiKey=9a24447e9d9caf7e2111')
if resp.status_code != 200:
    # This means something went wrong.
    raise ApiError('GET /tasks/ {}'.format(resp.status_code))
print(float(resp.json()['USD_GBP']))
print(float(resp.json()['EUR_GBP']))
