import requests
import csv
import sys
import json

data = []

keys = ["name", "address", "latitude", "longitude", "telNumber", "categoryName"]

with open(sys.argv[1]) as csv_file:
    reader = csv.reader(csv_file)
    for i, row in enumerate(reader):
        if i == 0: # header
            continue

        store = {}
        is_valid = True
        for j, column in enumerate(row[1:7]):
            if not column:
                is_valid = False
                break
            store[keys[j]] = column
        if is_valid:
            data.append(store)
        # data.append({
        #     "name": row[1],
        #     "address": row[2],
        #     "latitude": row[3],
        #     "longitude": row[4],
        #     "telNumber": row[5],
        #     "categoryName": row[6]
        # })

print(data);
body = {
    "stores": data
}
headers = {"Content-Type": "application/json; charset=utf-8"}
requests.post('http://localhost:8080/stores', headers=headers, data=json.dumps(body))