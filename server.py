from flask import Flask, jsonify, request
from flask_pymongo import PyMongo

app = Flask(__name__)
app.config["MONGO_URI"] = "mongodb+srv://home2:TTx2hODDsT7qNk6L@cluster0.1htwcnd.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0"
mongo = PyMongo(app)

@app.route('/create_workout', methods=['POST'])
def create_workout():
    data = request.json
    if not data:
        return jsonify({'error': 'No data provided'}), 400

    # Insert the workout data into MongoDB
    workout_id = mongo.db.workouts.insert_one(data).inserted_id

    return jsonify({'success': True, 'workout_id': str(workout_id)}), 200

if __name__ == '__main__':
    app.run(debug=True)
